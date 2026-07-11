package com.aita.ai;

import com.aita.context.AutomationContext;

public class AIRequest {

    private AutomationContext context;

    public AIRequest() {
    }

    public AIRequest(AutomationContext context) {
        this.context = context;
    }

    public AutomationContext getContext() {
        return context;
    }

    public void setContext(AutomationContext context) {
        this.context = context;
    }
}