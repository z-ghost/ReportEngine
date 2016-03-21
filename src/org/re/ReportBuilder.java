package org.re;

/**
 * Created by V.Zubchevskiy on 08.03.2016.
 */
public class ReportBuilder {

    private ITableElement[] columns;
    private ITableElement[] rows;
    private IProvider provider;
    private IStrategy strategy;

    public ReportBuilder columns(ITableElement... columns)
    {
        this.columns = columns;
        return this;
    }

    public ReportBuilder rows(ITableElement... rows) {
        this.rows = rows;
        return this;
    }

    public ReportBuilder provider(IProvider provider) {
        this.provider = provider;
        return this;
    }

    public ReportBuilder calcStrategy(IStrategy strategy) {
        this.strategy = strategy;
        return this;
    }

    public Report build() {
        return new ReportEngine(columns, rows, provider, strategy).make();
    }

    public ReportBuilder cellLinks(ILinkMaker linkMaker) {
        return this;
    }
}
