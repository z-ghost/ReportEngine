package org.re.html;

/**
 * Created by Vitaly on 27.03.2016.
 */
public class HtmlTableBuilder {
    private StringBuilder sb;
    boolean rowStared = false;

    public HtmlTableBuilder() {
        sb = new StringBuilder("<table>\n");
    }

    public HtmlTableBuilder tr() {
        if (rowStared)
            sb.append("</tr>\n");
        sb.append("<tr>\n");
        rowStared = true;
        return this;
    }

    public HtmlTableBuilder td(Object val) {
        sb.append("\t<td>").append(val).append("</td>\n");
        return this;
    }


    public HtmlTableBuilder th(String val) {
        sb.append("\t<th>").append(val).append("</th>\n");
        return this;
    }

    public String getHtml() {

        return sb.toString() + (rowStared ? "</tr>\n" : "") + "</table>";
    }
}
