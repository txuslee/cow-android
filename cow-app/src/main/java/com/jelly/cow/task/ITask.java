package com.jelly.cow.task;

public interface ITask<P, R>
{
    void doExecute(P parameter);
}
