[配套文章]
`https://zhoutianyu.blog.csdn.net/article/details/107019634`

`demo-archetype/pom.xml:固定模版，引入maven骨架基本依赖`

`META-INF/maven/archetype-metadata.xml:
    骨架配置文件：配置生成的多模块包，并且配置哪些文件需要被生成`
    
`resources/archetype-resources/pom.xml:构建的项目得最外层xml，导入基础包，并使用pom打包方式聚合项目`

`为什么要把start模块写死，因为要控制扫描我们的starter`
    
    
    
    
