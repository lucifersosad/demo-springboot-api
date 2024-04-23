package spring.security.demonht.service;

import spring.security.demonht.entity.SubjectEntity;

import java.util.List;

public interface ISubjectService {

    List<SubjectEntity> findAllById(Iterable<Long> longs);

    <S extends SubjectEntity> S save(S entity);

    long count();

    void deleteAll();

    void deleteById(Long aLong);

    boolean checkSubjectExisted(Long id);
}
