package com.aita.ai;

public class AIResponse {

    private String summary;
    private String rootCause;
    private String recommendation;
    private int confidence;

    public AIResponse() {
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getRootCause() {
        return rootCause;
    }

    public void setRootCause(String rootCause) {
        this.rootCause = rootCause;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public int getConfidence() {
        return confidence;
    }

    public void setConfidence(int confidence) {
        this.confidence = confidence;
    }

    @Override
    public String toString() {
        return """
                ----------------------------
                AI Failure Analysis
                ----------------------------
                Summary       : %s
                Root Cause    : %s
                Recommendation: %s
                Confidence    : %d%%
                """.formatted(summary,
                rootCause,
                recommendation,
                confidence);
    }
}