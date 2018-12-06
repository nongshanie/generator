package com.nongshanie.generator.service.impl;

import com.nongshanie.generator.service.GeneratorService;
import com.nongshanie.generator.utils.CodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: zhouxinhang
 * @date: 2018/12/6
 * @Description:
 */
@Service
public class GeneratorServiceImpl implements GeneratorService {


    @Autowired
    private CodeGenerator  codeGenerator;
    /**
     * @return
     * @Author zhouxinhang
     * @Description 用户生成代码
     * @Date 2018/12/6
     */
    @Override
    public void codeGenerator() throws Exception {
        CodeGenerator.generated();
    }
}
