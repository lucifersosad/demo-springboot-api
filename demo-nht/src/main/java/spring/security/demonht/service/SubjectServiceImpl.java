package spring.security.demonht.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.security.demonht.entity.SubjectEntity;
import spring.security.demonht.repository.SubjectRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements ISubjectService {
    @Autowired
    SubjectRepository subjectRepository;

    public List<SubjectEntity> findAll() {
        return subjectRepository.findAll();
    }

    public List<SubjectEntity> findAllById(Iterable<Long> longs) {
        return subjectRepository.findAllById(longs);
    }

    public <S extends SubjectEntity> S save(S entity) {
        return subjectRepository.save(entity);
    }

    public long count() {
        return subjectRepository.count();
    }

    public void deleteAll() {
        subjectRepository.deleteAll();
    }

    public void deleteById(Long aLong) {
        subjectRepository.deleteById(aLong);
    }

    public boolean checkSubjectExisted(Long id) {
        return subjectRepository.existsById(id);
    }

}
