package org.xtext;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

public class PlantumlValueConverter extends DefaultTerminalConverters {
    boolean Exists = false;
    String[] colorArray = {
    		"aliceblue","antiquewhite","aqua","aquamarine","azure","beige","bisque","black"
            ,"blanchedalmond","blue","blueviolet","brown","burlywood","cadetblue","chartreuse"
            ,"chocolate","coral","cornflowerblue","cornsilk","crimson","cyan","carkblue","darkcyan"
            ,"darkgoldenrod","darkgray","darkgreen","darkgrey","darkkhaki","darkmagenta","darkolivegreen"
            ,"darkorchid","darkred","darksalmon","darkseagreen","darkslateblue","darkslategray"
            ,"darkslategrey","darkturquoise","darkviolet","darkorange","deeppink","deepskyblue"
            ,"dimgray","dimgrey","dodgerblue","firebrick","floralwhite","forestgreen","fuchsia"
            ,"gainsboro","ghostwhite","gold","goldenrod","gray","green","greenyellow","grey"
            ,"honeydew","hotpink","indianred","indigo","ivory","khaki","lavender","lavenderblush"
            ,"lawngreen","lemonchiffon","lightblue","lightcoral","lightcyan","lightgoldenrodyellow"
            ,"lightgray","lightgreen","lightgrey","lightpink","lightsalmon","lightseagreen","lightskyblue"
            ,"lightslategray","lightslategrey","lightsteelblue","lightyellow","lime","limegreen","linen"
            ,"magenta","maroon","mediumaquamarine","mediumblue","mediumorchid","mediumpurple","mediumseagreen"
            ,"mediumslateblue","mediumspringgreen","mediumturquoise","mediumvioletred","midnightblue"
            ,"mintcream","mistyrose","moccasin","navajowhite","navy","oldlace","olive","olivedrab"
            ,"orange","orangered","orchid","palegoldenrod","palegreen","paleturquoise","palevioletred"
            ,"papayawhip","peachpuff","peru","pink","plum","powderblue","psurple","red","rosybrown"
            ,"royalblue","saddlebrown","salmon","sandybrown","seagreen","seashell"
            ,"sienna","silver","skyblue","slateblue","slategray","slategrey","snow","springgreen"
            ,"steelblue","tan","teal","thistle","tomato","turquoise","violet","wheat","white"
            ,"whitesmoke","yellow","yellowgreen"
    };
    
    boolean found = false;
    
    @ValueConverter(rule = "Color")
    public IValueConverter<String> Color(){
        return new IValueConverter<String>(){

            @Override
            public String toValue(String string, INode node) throws ValueConverterException{
            	// If colorArray does not contains string
            	if (!org.eclipse.xtext.util.Arrays.contains(colorArray, string.toLowerCase())
            			&& !string.toLowerCase().matches("^\\s*[0-9a-f]*\\s*$")) {
            			throw new ValueConverterException("Not a Color: " + string, node, null);
	            	}

            	else{
        			return string;
        		}
            }

            @Override
            public String toString(String value)
                            throws ValueConverterException {
                    // Auto-generated method stub
                    return value;
            }              
        };
    }
}