package org.funcala.compiler.bytecode;

import org.apache.commons.io.IOUtils;
import org.funcala.compiler.model.FuncalaBlock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by feilaoda on 16/10/26.
 */
public class FuncalaGenerator {
    private final static Logger LOGGER = LoggerFactory.getLogger(FuncalaGenerator.class);

    public void generate(FuncalaBlock funcalaBlock) throws FileNotFoundException {
        funcalaBlock.getClassBlockList().stream().forEach(classBlock -> {
            try {
                ClassGenerator bytecodeGenerator = new ClassGenerator();
                String className = classBlock.getName();
                String fileName = className + ".class";
                LOGGER.info("Finished Compiling. Saving bytecode to '{}'.", fileName);
                OutputStream os = new FileOutputStream(fileName);
                byte[] bytecode = bytecodeGenerator.generate(classBlock);
                IOUtils.write(bytecode, os);
                LOGGER.info("Done. To run compiled file execute: 'java {}' in current dir", className);
            }catch (FileNotFoundException e) {
                LOGGER.error(e.getMessage(), e);
            }catch (IOException e) {
                LOGGER.error(e.getMessage(), e);
            }
        });
    }
}
