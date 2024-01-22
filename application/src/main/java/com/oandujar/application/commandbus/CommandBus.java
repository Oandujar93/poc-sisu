package com.oandujar.application.commandbus;

public interface CommandBus {

    <T> T dispatch(Command<T> command) throws Exception;
}