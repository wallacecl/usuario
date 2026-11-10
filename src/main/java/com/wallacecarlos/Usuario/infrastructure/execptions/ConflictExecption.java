package com.wallacecarlos.Usuario.infrastructure.execptions;

public class ConflictExecption  extends  RuntimeException{
    public ConflictExecption (String mensagem){
        super(mensagem);
    }

    public ConflictExecption(String mensagem, Throwable trowable){
        super(mensagem);
    }
}
