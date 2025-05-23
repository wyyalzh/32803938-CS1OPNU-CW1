package datamanager.transform;

public class TransformerFactory {

    public static Transformer createTransformer(String type) {
        String key = type.toLowerCase();
        switch (key) {
            case "greater":
                return new FilterGreaterThanTransformer();
            // 未来你可以添加：
            // case "less":
            //     return new FilterLessThanTransformer();
            // case "equals":
            //     return new FilterEqualsTransformer();
            default:
                return null;
        }
    }
}

