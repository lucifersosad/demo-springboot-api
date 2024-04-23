package spring.security.demonht.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.security.demonht.entity.SubjectEntity;
import spring.security.demonht.repository.SubjectRepository;

import java.util.List;

@Service
public class SubjectServiceImpl implements ISubjectService {
    @Autowired
    SubjectRepository subjectRepository;

    public List<SubjectEntity> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public List<SubjectEntity> findAllById(Iterable<Long> longs) {
        return subjectRepository.findAllById(longs);
    }

    @Override
    public <S extends SubjectEntity> S save(S entity) {
        return subjectRepository.save(entity);
    }

    @Override
    public long count() {
        return subjectRepository.count();
    }

    @Override
    public void deleteAll() {
        subjectRepository.deleteAll();
    }

    @Override
    public void deleteById(Long aLong) {
        subjectRepository.deleteById(aLong);
    }

    @Override
    public boolean checkSubjectExisted(Long id) {
        return subjectRepository.existsById(id);
    }

}
