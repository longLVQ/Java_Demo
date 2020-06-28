package com.longlvq.mybatis_h2db.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.longlvq.mybatis_h2db.entity.PerSonEntity;

@Mapper
public interface PerSonRepository {
    public PerSonEntity selectStudentById(int studentId);
    public List<PerSonEntity> selectAllStudent();
}
