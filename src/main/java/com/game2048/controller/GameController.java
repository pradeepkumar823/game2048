package com.game2048.controller;

import com.game2048.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("board", gameService.getBoard());
        return "index";
    }

    @PostMapping("/move")
    public String move(@RequestParam String direction, Model model) {
        gameService.move(direction);
        model.addAttribute("board", gameService.getBoard());
        return "index";
    }

    @PostMapping("/reset")
    public String resetGame(Model model) {
        gameService.resetGame();
        model.addAttribute("board", gameService.getBoard());
        return "index";
    }
}
