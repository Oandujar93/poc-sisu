package com.oandujar.application.commandbus;

public interface CommandHandler<T, U extends Command<T>> {

    T handle(U command) throws Exception;
}