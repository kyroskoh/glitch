import com.gorylenko.GitPropertiesPluginExtension

plugins {
    id("com.gorylenko.gradle-git-properties")
}

dependencies {
    compile("org.apache.commons:commons-collections4:4.3")

    compile("com.squareup.okhttp3:okhttp:3.13.1")
    compile("com.squareup.okhttp3:logging-interceptor:3.13.1")

    compile("com.fatboyindustrial.gson-javatime-serialisers:gson-javatime-serialisers:1.1.1") // GSON java.time serialization
    compile("com.google.code.gson:gson:2.8.5")
    compile("com.google.code.findbugs:jsr305:3.0.2")

    compile("io.projectreactor:reactor-core")

    testCompile("com.squareup.okhttp3:mockwebserver:3.13.1")
}
extensions.getByType<GitPropertiesPluginExtension>().apply {
    keys = listOf(
            "git.branch",
            "git.commit.id",
            "git.commit.id.abbrev",
            "git.commit.id.describe"
    )
    dateFormatTimeZone = "GMT"
    customProperty("application.name", rootProject.name)
    customProperty("application.version", rootProject.version)
    customProperty("application.url", ext.properties["project_url"])
    customProperty("application.description", rootProject.description)
}