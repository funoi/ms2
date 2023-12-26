package com.dao;

import com.vo.Stu;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IStu {
    @Select("select * from students")
    public List<Stu> findAll();

    @Select("select * from students where id=#{id}")
    public Stu findById(@Param("id")Integer id);

    @Select("insert into students values (#{id},#{name},#{sex})")
    public void insert(Stu stu);

    @Update("update students set name=#{name},sex=#{sex} where id=#{id}")
    public void update(Stu stu);

    @Delete("delete from students where id=#{id}")
    public void delete(@Param("id") Integer id);
}
