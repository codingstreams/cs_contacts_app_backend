package com.codingstreams.contactsapplication.service.label;

import com.codingstreams.contactsapplication.exception.LabelNotFoundException;
import com.codingstreams.contactsapplication.model.Label;

import java.util.List;

public interface LabelService {
    List<Label> getLabels();

    Label saveLabel(Label label);

    Label updateLabel(Integer id, Label label) throws LabelNotFoundException;

    void deleteLabel(Integer id) throws LabelNotFoundException;
}
