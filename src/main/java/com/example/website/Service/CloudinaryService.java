package com.example.website.Service;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@Service
public class CloudinaryService {

    private final Cloudinary cloudinary;

    public CloudinaryService() {
        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "digj03drq",
                "api_key", "395915431482254",
                "api_secret", "t1nvSX_zgScbn5HCrPVCoGuBYxM"
        ));
    }

    public String uploadImage(MultipartFile file) {
        try {
            Map<String, Object> params = ObjectUtils.asMap(
                    "transformation", new Transformation().width(500).height(500).crop("limit")
            );

            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), params);
            return (String) uploadResult.get("public_id");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteImage(String publicId) {
        try {
            cloudinary.api().deleteResources(Arrays.asList(publicId),
                    ObjectUtils.asMap("type", "upload", "resource_type", "image"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}