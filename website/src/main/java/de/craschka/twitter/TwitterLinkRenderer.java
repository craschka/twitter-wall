package de.craschka.twitter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;
import javax.inject.Inject;
import java.io.IOException;

@FacesRenderer(componentFamily = "javax.faces.Output", rendererType = "de.craschka.twitter.TwitterLinkRenderer")
public class TwitterLinkRenderer extends Renderer {

    @Inject
    ContentItemCreator contentItemCreator;

    @Override
    public void encodeBegin(FacesContext facesContext, UIComponent uiComponent) throws IOException {
        TwitterLink link = (TwitterLink) uiComponent;
        String clientId = link.getClientId();
        encodeInput(facesContext, link, clientId);
    }

    private void encodeInput(FacesContext facesContext, TwitterLink link, String clientId) throws IOException {
        ResponseWriter writer = facesContext.getResponseWriter();
        ContentItemCreator.encodeItems(writer, link.getMessage(),link);
    }


}
