package spring.security.demonht.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import spring.security.demonht.entity.SubjectEntity;
import spring.security.demonht.model.SubjectResponse;
import spring.security.demonht.service.SubjectServiceImpl;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {
    @Autowired
    SubjectServiceImpl subjectService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<SubjectResponse> listAll() {
        List<SubjectEntity> list = subjectService.findAll();
        if (!list.isEmpty()) {
            SubjectResponse response = new SubjectResponse();
            response.setSuccess(true);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Lay danh sach mon hoc thanh cong");
            response.setMonhoc(list);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<SubjectResponse> addSubject(@Validated @RequestBody SubjectEntity subject) {
        subjectService.save(subject);
        List<SubjectEntity> list = subjectService.findAll();
        if (!list.isEmpty()) {
            SubjectResponse response = new SubjectResponse();
            response.setSuccess(true);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Them mon hoc thanh cong");
            response.setMonhoc(list);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public ResponseEntity<SubjectResponse> updateSubject(@Validated @RequestBody SubjectEntity subject) {
        if (subjectService.checkSubjectExisted(subject.getId())) {
            subjectService.save(subject);
            List<SubjectEntity> list = subjectService.findAll();
            SubjectResponse response = new SubjectResponse();
            response.setSuccess(true);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Sua mon hoc thanh cong");
            response.setMonhoc(list);
            return ResponseEntity.ok(response);

        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<SubjectResponse> deleteSubject(@Validated @RequestBody SubjectEntity subject) {
        if (subjectService.checkSubjectExisted(subject.getId())) {
            subjectService.deleteById(subject.getId());
            List<SubjectEntity> list = subjectService.findAll();
            SubjectResponse response = new SubjectResponse();
            response.setSuccess(true);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Xoa mon hoc thanh cong");
            response.setMonhoc(list);
            return ResponseEntity.ok(response);

        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    public ResponseEntity<SubjectResponse> deleteAllSubject() {
        subjectService.deleteAll();
        List<SubjectEntity> list = subjectService.findAll();
        SubjectResponse response = new SubjectResponse();
        response.setSuccess(true);
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("Xoa tat ca mon hoc thanh cong");
        response.setMonhoc(list);
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<SubjectResponse> getSubject(@PathVariable(value = "id") Long id) {
        if (subjectService.checkSubjectExisted((id))) {
            List<Long> idList = new ArrayList<>();
            idList.add(id);
            List<SubjectEntity> list = subjectService.findAllById(idList);
            SubjectResponse response = new SubjectResponse();
            response.setSuccess(true);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Lay mon hoc thanh cong");
            response.setMonhoc(list);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }
}
