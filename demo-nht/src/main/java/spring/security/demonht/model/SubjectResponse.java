package spring.security.demonht.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.security.demonht.entity.SubjectEntity;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectResponse extends Response{
    private List<SubjectEntity> monhoc;
}
