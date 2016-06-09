package org.protege.editor.owl.client;

/**
 * @author Josef Hardi <johardi@stanford.edu> <br>
 * Stanford Center for Biomedical Informatics Research
 */
public interface ClientSessionListener {

    void handleChange(ClientSessionChangeEvent event);
}
