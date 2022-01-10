package com.crud.tasks.controller;

import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.service.TrelloService;
import com.crud.tasks.trello.facade.TrelloFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/trello")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class TrelloController {

    private static final String KODILLA = "Kodilla";
    private final TrelloFacade trelloFacade;

    /*@GetMapping("getTrelloBoards")
    public void getTrelloBoards() {

        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();

        trelloBoards.stream()
                .filter(trelloBoardDto -> !trelloBoardDto.getId().isEmpty() && !trelloBoardDto.getName().isEmpty())
                .filter(trelloBoardDto -> trelloBoardDto.getName().contains(KODILLA))
                .collect(Collectors.toList())
                .forEach(trelloBoardDto -> System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName()));
    }*/

    @GetMapping("getTrelloBoards")
    public List<TrelloBoardDto> getTrelloBoards() {
        return trelloFacade.fetchTrelloBoards();
    }

    @PostMapping("createTrelloCard")
    public CreatedTrelloCardDto createTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {
        return trelloFacade.createCard(trelloCardDto);
    }
}