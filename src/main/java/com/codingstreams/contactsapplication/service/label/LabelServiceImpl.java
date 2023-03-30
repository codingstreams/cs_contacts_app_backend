package com.codingstreams.contactsapplication.service.label;

import com.codingstreams.contactsapplication.exception.LabelNotFoundException;
import com.codingstreams.contactsapplication.model.Label;
import com.codingstreams.contactsapplication.repository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LabelServiceImpl implements LabelService {
    @Autowired
    private LabelRepository labelRepository;

    @Override
    public List<Label> getLabels() {
        ArrayList<Label> labels = new ArrayList<>();
        labelRepository.findAll().forEach(labels::add);

        return labels;
    }

    @Override
    public Label saveLabel(Label label) {
        return labelRepository.save(label);
    }

    @Override
    public Label updateLabel(Integer id, Label label) throws LabelNotFoundException {
        // Check if label exists or not
        boolean exists = labelRepository.existsById(id);

        // If not exists then throw error
        if (!exists) throw new LabelNotFoundException();

        // Else Update label
        label.setId(id);

        return labelRepository.save(label);
    }

    @Override
    public void deleteLabel(Integer id) throws LabelNotFoundException {
        // Check if label exists or not
        boolean exists = labelRepository.existsById(id);

        // If not exists then throw error
        if (!exists) throw new LabelNotFoundException();

        // Else delete label
        labelRepository.deleteById(id);
    }
}
