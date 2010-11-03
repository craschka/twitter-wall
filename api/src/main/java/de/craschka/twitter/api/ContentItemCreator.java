package de.craschka.twitter.api;

import javax.faces.view.facelets.FaceletContext;
import java.util.ArrayList;
import java.util.List;

public class ContentItemCreator {
    public static List<ContentItem> createContentItems(String content) {
        List<ContentItem> contentItems = new ArrayList<ContentItem>();
        String[] words = content.split(" ");
        for (String word : words) {
            if (word.startsWith("http")){
                contentItems.add(new LinkContentItem(word));
            } else {
                contentItems.add(new TextContentItem(word));
            }
        }
        return contentItems;
    }
}
