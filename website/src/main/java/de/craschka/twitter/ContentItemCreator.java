package de.craschka.twitter;

import de.craschka.twitter.api.ContentItem;
import de.craschka.twitter.api.LinkContentItem;
import de.craschka.twitter.api.TextContentItem;

import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.component.UIOutput;
import javax.faces.component.html.HtmlOutputLink;
import javax.faces.view.facelets.FaceletContext;
import java.util.ArrayList;
import java.util.List;

public class ContentItemCreator {
    public static List<UIComponent> createContentItems(String content, Application application) {
        List<UIComponent> components = new ArrayList<UIComponent>();

        String[] words = content.split(" ");
        for (String word : words) {
            if (word.startsWith("http")){
                components.add(createLink(word,application));
            } else {
                components.add(createOutput(word,application));
            }
        }
        return components;
    }

    private static UIComponent createOutput(String word, Application application) {
        UIOutput out = (UIOutput) application.createComponent(UIOutput.COMPONENT_TYPE);
        out.setValue(word);

        return out;
    }

    private static UIComponent createLink(String word, Application application) {
        HtmlOutputLink link = (HtmlOutputLink) application.createComponent(HtmlOutputLink.COMPONENT_TYPE);
        link.setValue(word);

        link.getChildren().add(createOutput(word,application));

        return link;
    }
}
