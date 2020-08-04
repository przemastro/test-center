package utils


import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.yaml.snakeyaml.Yaml;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.reflect.KClass


class DataUtil {

    object YAMLParse {
        private val mapper = let {
            val mapper = ObjectMapper(YAMLFactory())
            mapper.registerModule(KotlinModule())
            mapper
        }

        fun <T: Any> parseProp(fileName: String, prop: KClass<T>): T {
            return Files.newBufferedReader(FileSystems.getDefault().getPath(fileName)).use { mapper.readValue(it, prop.java) }
        }
    }
}
