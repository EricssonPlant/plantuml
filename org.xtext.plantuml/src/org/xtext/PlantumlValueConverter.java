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
                    "AliceBlue","AntiqueWhite","Aqua","Aquamarine","Azure","Beige","Bisque","Black"
                    ,"BlanchedAlmond","Blue","BlueViolet","Brown","BurlyWood","CadetBlue","Chartreuse"
                    ,"Chocolate","Coral","CornflowerBlue","Cornsilk","Crimson","Cyan","DarkBlue","DarkCyan"
                    ,"DarkGoldenRod","DarkGray","DarkGreen","DarkGrey","DarkKhaki","DarkMagenta","DarkOliveGreen"
                    ,"DarkOrchid","DarkRed","DarkSalmon","DarkSeaGreen","DarkSlateBlue","DarkSlateGray"
                    ,"DarkSlateGrey","DarkTurquoise","DarkViolet","Darkorange","DeepPink","DeepSkyBlue"
                    ,"DimGray","DimGrey","DodgerBlue","FireBrick","FloralWhite","ForestGreen","Fuchsia"
                    ,"Gainsboro","GhostWhite","Gold","GoldenRod","Gray","Green","GreenYellow","Grey"
                    ,"HoneyDew","HotPink","IndianRed","Indigo","Ivory","Khaki","Lavender","LavenderBlush"
                    ,"LawnGreen","LemonChiffon","LightBlue","LightCoral","LightCyan","LightGoldenRodYellow"
                    ,"LightGray","LightGreen","LightGrey","LightPink","LightSalmon","LightSeaGreen","LightSkyBlue"
                    ,"LightSlateGray","LightSlateGrey","LightSteelBlue","LightYellow","Lime","LimeGreen","Linen"
                    ,"Magenta","Maroon","MediumAquaMarine","MediumBlue","MediumOrchid","MediumPurple","MediumSeaGreen"
                    ,"MediumSlateBlue","MediumSpringGreen","MediumTurquoise","MediumVioletRed","MidnightBlue"
                    ,"MintCream","MistyRose","Moccasin","NavajoWhite","Navy","OldLace","Olive","OliveDrab"
                    ,"Orange","OrangeRed","Orchid","PaleGoldenRod","PaleGreen","PaleTurquoise","PaleVioletRed"
                    ,"PapayaWhip","PeachPuff","Peru","Pink","Plum","PowderBlue","Psurple","Red","RosyBrown"
                    ,"RoyalBlue","SaddleBrown","Salmon","SandyBrown","SeaGreen","SeaShell"
                    ,"Sienna","Silver","SkyBlue","SlateBlue","SlateGray","SlateGrey","Snow","SpringGreen"
                    ,"SteelBlue","Tan","Teal","Thistle","Tomato","Turquoise","Violet","Wheat","White"
                    ,"WhiteSmoke","Yellow","YellowGreen"
    };
    
    boolean found = false;
    
    @ValueConverter(rule = "Color")
    public IValueConverter<String> Color(){
            return new IValueConverter<String>(){

                    @Override
                    public String toValue(String string, INode node) throws ValueConverterException{
                    	// If colorArray does not contains string
                    		if (org.eclipse.xtext.util.Arrays.contains(colorArray, string)) {
                        			throw new ValueConverterException("Not a Color", node, null);
                        	}
                    		else return string;
                    		
                    		// TODO: Fix for hexcode
                    	/*if(! string.matches("^\\s*[0-9A-Fa-f]*\\s*$")){
                    		throw new ValueConverterException("Not a Color", node, null);
                    	}
                    	else return string;*/
                    	
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