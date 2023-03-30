package com.codingstreams.contactsapplication.controller;

import com.codingstreams.contactsapplication.exception.LabelNotFoundException;
import com.codingstreams.contactsapplication.model.Label;
import com.codingstreams.contactsapplication.service.label.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/labels")
public class LabelController {
    @Autowired
    private LabelService labelService;

    @GetMapping("/")
    public List<Label> getLabels() {
        return labelService.getLabels();
    }

    @PostMapping("/")
    public Label addLabel(@RequestBody Label label) {
        return labelService.saveLabel(label);
    }

    @PutMapping("/{id}")
    public Label updateLabel(@PathVariable Integer id, @RequestBody Label label) throws LabelNotFoundException {
        return labelService.updateLabel(id, label);
    }

    @DeleteMapping("/{id}")
    public void deleteLabel(@PathVariable Integer id) throws LabelNotFoundException {
        labelService.deleteLabel(id);
    }

}
