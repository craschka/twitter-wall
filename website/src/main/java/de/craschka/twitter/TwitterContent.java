package de.craschka.twitter;

import de.craschka.twitter.api.*;
import de.craschka.twitter.ContentItemCreator;

import javax.faces.component.UIComponent;
import javax.faces.component.UIOutput;
import javax.faces.component.html.HtmlOutputLink;
import javax.faces.context.ResponseWriter;
import javax.faces.view.facelets.FaceletContext;
import javax.faces.view.facelets.TagAttribute;
import javax.faces.view.facelets.TagConfig;
import javax.faces.view.facelets.TagHandler;
import javax.inject.Inject;
import java.io.IOException;
import java.util.Date;
import java.util.List;


public class TwitterContent extends TagHandler {
    private TagAttribute message;

    @Inject
    private ContentItemCreator contentItemCreator;

    public TwitterContent(TagConfig tagConfig) {
        super(tagConfig);
        this.message = this.getRequiredAttribute("message");
    }


    @Override
    public void apply(FaceletContext context, UIComponent parent) throws IOException {

        String content = (String) context.getExpressionFactory().createValueExpression(context,message.getValue(),String.class).getValue(context);

        parent.getChildren().addAll(contentItemCreator.createContentItems(content,context.getFacesContext().getApplication()));
    }
}
