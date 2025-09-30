plugins {
    id("java")
}

group = "net.rimaki.emotax"
version = "1.0-SNAPSHOT+2025-09-30"

repositories {
    mavenCentral()
    maven{
        url = uri("https://jitpack.io")
    }
    maven{
        url = uri("https://oss.sonatype.org/content/repositories/snapshots/")
    }
    maven{
        url = uri("https://repo.opencollab.dev/maven-snapshots")
    }
    maven{
        url = uri("https://repo.opencollab.dev/maven-releases")
    }
    maven{
        url = uri("https://repo.powernukkitx.org/releases")
    }
}

dependencies {
    implementation("com.github.PowerNukkitX:PowerNukkitX:master-SNAPSHOT")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}