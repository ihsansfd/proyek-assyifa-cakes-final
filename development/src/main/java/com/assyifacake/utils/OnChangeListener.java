/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assyifacake.utils;

import java.beans.PropertyChangeEvent;
import java.util.Objects;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;

/**
 *
 * @author user
 */
public class OnChangeListener {
    
    public static void addChangeListener(JTextComponent text, ChangeListener changeListener) {
    Objects.requireNonNull(text);
    Objects.requireNonNull(changeListener);
    DocumentListener dl = new DocumentListener() {
        private int lastChange = 0, lastNotifiedChange = 0;

        @Override
        public void insertUpdate(DocumentEvent e) {
            changedUpdate(e);
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            changedUpdate(e);
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            lastChange++;
            SwingUtilities.invokeLater(() -> {
                if (lastNotifiedChange != lastChange) {
                    lastNotifiedChange = lastChange;
                    changeListener.stateChanged(new ChangeEvent(text));
                }
            });
        }
    };
    text.addPropertyChangeListener("document", (PropertyChangeEvent e) -> {
        Document d1 = (Document)e.getOldValue();
        Document d2 = (Document)e.getNewValue();
        if (d1 != null) d1.removeDocumentListener(dl);
        if (d2 != null) d2.addDocumentListener(dl);
        dl.changedUpdate(null);
    });
    Document d = text.getDocument();
    if (d != null) d.addDocumentListener(dl);
}
    
}
