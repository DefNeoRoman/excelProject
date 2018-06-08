package stepik.fridayWorkWrong;

import java.util.Objects;

public class KeyValue<K,V> {
    K first;
    V second;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyValue<?, ?> keyValue = (KeyValue<?, ?>) o;

        return Objects.equals(first, keyValue.first) &&
                Objects.equals(second, keyValue.second);
    }

    @Override
    public int hashCode() {
        if(first == null || second == null){
            return 31;
        }
        int result = 31 * first.hashCode();
        result = result + result*second.hashCode();
        return result;
    }
}
