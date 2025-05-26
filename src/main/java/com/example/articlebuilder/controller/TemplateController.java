package com.example.articlebuilder.controller;

import java.util.List;
import com.example.articlebuilder.model.Template;
import com.example.articlebuilder.repository.TemplateRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/templates")
public class TemplateController {
  private final TemplateRepository templateRepository;

  public TemplateController(TemplateRepository templateRepository) {
    this.templateRepository = templateRepository;
  }

  @GetMapping
  public List<Template> getAllTemplates() {
    return templateRepository.findAll();
  }

  @PostMapping
  public Template createTemplate(@RequestBody Template template) {
    return templateRepository.save(template);
  }

  @GetMapping("/{id}")
  public Template getTemplateById(@PathVariable Long id) {
    return templateRepository.findById(id).orElseThrow(() -> new RuntimeException("Template not found"));
  }
}
