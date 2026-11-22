package praktikum.support;

import java.util.Optional;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

public class TestRunLogger implements BeforeEachCallback, TestWatcher {
    @Override
    public void beforeEach(ExtensionContext context) {
        log(context, "Запуск");
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        log(context, "Пройден");
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        log(context, "Ошибка: " + cause);
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        log(context, "Прерван: " + cause);
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        log(context, "Пропущен: " + reason.orElse("причина не указана"));
    }

    private void log(ExtensionContext context, String status) {
        System.out.printf("[%s] %s — %s%n", status, context.getRequiredTestClass().getSimpleName(),
                context.getDisplayName());
    }
}
