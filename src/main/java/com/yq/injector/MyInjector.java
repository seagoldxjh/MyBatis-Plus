package com.yq.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.AbstractSqlInjector;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.injector.methods.*;
import com.yq.injector.methods.MyDelete;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MyInjector extends AbstractSqlInjector {


    @Override
    public List<AbstractMethod> getMethodList() {

        List<AbstractMethod> methodList = new DefaultSqlInjector().getMethodList();
        methodList.add(new MyDelete());
        return methodList ;
//        return Stream.of(
//                new Insert(),
//                new Delete(),
//                new DeleteByMap(),
//                new DeleteById(),
//                new DeleteBatchByIds(),
//                new Update(),
//                new UpdateById(),
//                new SelectById(),
//                new SelectBatchByIds(),
//                new SelectByMap(),
//                new SelectOne(),
//                new SelectCount(),
//                new SelectMaps(),
//                new SelectMapsPage(),
//                new SelectObjs(),
//                new SelectList(),
//                new SelectPage(),
//                new MyDelete()
//        ).collect(toList());
    }


}
