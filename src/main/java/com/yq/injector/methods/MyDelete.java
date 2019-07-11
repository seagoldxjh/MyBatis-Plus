package com.yq.injector.methods;

import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

public class MyDelete  extends AbstractMethod {
    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        String sql;
        SqlMethod sqlMethod = SqlMethod.LOGIC_DELETE;
     //真删除
    sql = "delete from tb_student where stu_no >3 " ;
    SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);

    return this.addDeleteMappedStatement(mapperClass, "deleteAllStudents", sqlSource);
    }
}
