package com.example.demo.demo.Tictactoe;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(path = "api/v1/boards")
@ResponseBody
public class Controller {

  private final Services services;

  @Autowired
  public Controller(Services services) {
    this.services = services;
  }

  @GetMapping("/win")
  public Map<String, String> checkWin() {
    int[][] board = new int[3][3];
    board[0][0] = 1;
    board[0][2] = 1;
    board[0][1] = 1;
    return services.check(board);
  }

}
