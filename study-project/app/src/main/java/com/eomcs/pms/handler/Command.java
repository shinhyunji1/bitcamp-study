package com.eomcs.pms.handler;

public interface Command {
  void execute(CommandRequest requset) throws Exception;
}
