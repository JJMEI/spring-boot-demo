package com.meijunjie.springboot.validation;

import java.util.HashMap;

/**
 *
 * @author meijunjie
 * @date 2018/9/20
 */

public class ValidateResult extends HashMap<String, Object>{
    private static final long serialVersionUID = 7242891108608346915L;

    public ValidateResult(){}

    public ValidateResult(String key, Object msg){this.put(key,msg);}

    public void addError(String key, Object msg){this.put(key,msg);}

    public boolean hasError(){return this.size() > 0 ;}
}
