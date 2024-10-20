package com.innovatech.support.controller;

import com.innovatech.support.entity.Question;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/support") // Ruta base
public class SupportController {

    private List<Question> questions = new ArrayList<>();

    public SupportController() {
        // Inicializar preguntas
        questions.add(new Question(1L, "How can I subscribe to a plan?", null, "Nike_col", "user1"));
        questions.add(new Question(2L, "How can I manage finances for my business?", "You can manage finances using the Business Manager module.", "Adidas_col", "user2"));
        questions.add(new Question(3L, "Can I subscribe to as many bazaars as I want?", null, "Business_x", "user3"));
        questions.add(new Question(4L, "What can I use advertising for on Made-in?", null, "Business_y", "user4"));
    }

    // Obtener preguntas por página
    @GetMapping("/questions")
    public List<Question> getAllQuestions(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        int start = page * size;
        int end = Math.min(start + size, questions.size());
        return questions.subList(start, end);
    }

    // Crear una nueva pregunta
    @PostMapping("/questions")
    public Question createQuestion(@RequestBody Question question) {
        question.setId((long) (questions.size() + 1)); // Asigna un nuevo ID
        questions.add(question); // Agrega la pregunta a la lista
        return question; // Retorna la pregunta creada
    }

    // Obtener una pregunta por ID
    @GetMapping("/questions/{id}")
    public Question getQuestionById(@PathVariable Long id) {
        return questions.stream()
                .filter(q -> q.getId().equals(id))
                .findFirst()
                .orElse(null); // Retorna null si no se encuentra la pregunta
    }

    @GetMapping("/questions/count")
    public long getQuestionsCount() {
        return questions.size();
    }
}
