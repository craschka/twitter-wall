package de.craschka.twitter;

import de.craschka.twitter.api.ContentItem;
import de.craschka.twitter.api.LinkContentItem;
import de.craschka.twitter.api.TextContentItem;

import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.component.UIOutput;
import javax.faces.component.html.HtmlOutputLink;
import javax.faces.context.ResponseWriter;
import javax.faces.view.facelets.FaceletContext;
import java.io.IOException;
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

    public static void encodeItems(ResponseWriter writer, String message, TwitterLink link) throws IOException {
        String[] words = message.split(" ");
        for (String word : words) {
            if (word.startsWith("http://twitpic")){
                encodeTwitpic(writer,word,link);
            } else if (word.startsWith("http")){
                encodeLink(writer,word, link);
            } else if (word.startsWith("@")){
                encodeAuthorLink(writer,word,link);
            }
            else {
                encodeText(writer,word, link);
            }
            writer.writeText(" ",null);
        }
    }

    private static void encodeTwitpic(ResponseWriter writer, String word, TwitterLink link) throws IOException {
        writer.startElement("img", link);
        String imageid = getTwitpicImageId(word);
        writer.writeAttribute("src","http://twitpic.com/show/mini/"+imageid,null);
        writer.endElement("img");
    }

    private static String getTwitpicImageId(String word) {
        return word.substring(word.lastIndexOf('/'));
    }

    private static void encodeAuthorLink(ResponseWriter writer, String word, TwitterLink link) throws IOException {
        writer.startElement("a", link);
        writer.writeAttribute("href","http://twitter.com/"+word.substring(1),null);
        writer.writeText(word,null);
        writer.endElement("a");    }

    private static void encodeText(ResponseWriter writer, String word, TwitterLink link) throws IOException {
        writer.writeText(word,null);
    }

    private static void encodeLink(ResponseWriter writer, String word, TwitterLink link) throws IOException {
        writer.startElement("a", link);
        writer.writeAttribute("href",word,null);
        writer.writeText(word,null);
        writer.endElement("a");
    }
}
