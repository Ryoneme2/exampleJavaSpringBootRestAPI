package com.example.demo.demo.Tictactoe;

import java.util.Map;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.demo.Tictactoe.Board.Board;
import com.example.demo.demo.Tictactoe.model.Response;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "api/v1/boards")
@ResponseBody
public class Controller {

  private final Services services;

  @Autowired
  public Controller(Services services) {
    this.services = services;
  }

  @GetMapping("/test")
  public ResponseEntity<Response> win() {
    LocalDateTime date = LocalDateTime.now();
    return ResponseEntity.ok(
        Response.builder()
            .timeStamp(date)
            .message("success")
            .statusCode(200)
            .status("OK")
            .data(Map.of("isWin", "win", "data", new int[3][3]))
            .build());
  }

  @PostMapping(value = "/win")
  public ResponseEntity<Response> checkWin(@RequestBody Board board) {
    String isWin = services.check(board);
    System.out.println(isWin);
    if (isWin != "null")
      return ResponseEntity.ok(
          Response.builder()
              .timeStamp(LocalDateTime.now())
              .message("success")
              .statusCode(200)
              .status("OK")
              .data(Map.of(
                  "isWin", isWin,
                  "field", board.getField()))
              .build());

    int[][] newBoard = services.getBoardBotMove(board);

    return ResponseEntity.ok(
        Response.builder()
            .timeStamp(LocalDateTime.now())
            .message("success")
            .statusCode(200)
            .status("OK")
            .data(Map.of(
                "isWin", services.check(new Board(newBoard)),
                "field", newBoard))
            .build());

  }

}
