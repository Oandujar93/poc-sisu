package com.oandujar.sisu.application.commandbus;

public interface CommandBus {

    <T> T dispatch(Command<T> command) throws Exception;
}