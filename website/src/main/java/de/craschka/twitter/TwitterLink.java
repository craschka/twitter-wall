package de.craschka.twitter;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIOutput;
import javax.inject.Inject;

@FacesComponent("de.craschka.twitter.TwitterLink")
public class TwitterLink extends UIOutput {

    public static final String COMPONENT_TYPE = "de.craschka.twitter.TwitterLink";

    enum PropertyKeys {
        message
    }

    public TwitterLink() {
        setRendererType("de.craschka.twitter.TwitterLink");
    }

    public String getMessage() {
        return (String) getStateHelper().eval(
                PropertyKeys.message);
    }

    public void setMessage(String message) {
        getStateHelper().put(PropertyKeys.message, message);
    }

    
}
