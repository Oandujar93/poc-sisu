package com.oandujar.sisu.application.commandbus;

public interface CommandHandler<T, U extends Command<T>> {

    T handle(U command) throws Exception;
}