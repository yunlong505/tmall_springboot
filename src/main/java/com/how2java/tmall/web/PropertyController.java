package com.how2java.tmall.web;


import com.how2java.tmall.pojo.Property;
import com.how2java.tmall.service.PropertyService;
import com.how2java.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
public class PropertyController {
    @Autowired
    PropertyService propertyService;

    @GetMapping("/categories/{cid}/properties")
    public Page4Navigator<Property> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size, @PathVariable(value = "cid") int cid) {
        start = start < 0 ? 0 : start;
        return propertyService.list(cid, start, size, 5);
    }

    @PostMapping("/properties")
    public Property add(@RequestBody Property property) {
        propertyService.add(property);
        return property;
    }

    @GetMapping("/properties/{id}")
    public Property get(@PathVariable(value = "id") int id) {
        return propertyService.get(id);
    }

    @DeleteMapping("/properties/{id}")
    public String delete(@PathVariable(value = "id") int id) {
        propertyService.delete(id);
        return null;
    }

    @PutMapping("/properties")
    public Object update(@RequestBody Property bean) throws Exception {
        propertyService.update(bean);
        return bean;
    }
}
