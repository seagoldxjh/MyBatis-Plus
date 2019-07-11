package com.yq.entity;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.extension.activerecord.Model;

@KeySequence(value="seq_stu",clazz = Integer.class)
public abstract class Parent extends Model<Student> {
}
