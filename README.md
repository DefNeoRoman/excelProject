# excelProject

Шаблон для создания xls документа

1. groups.json - шаблон

 Name - имя самого верхнего ряда. (Колонка будет состоять из объединенных ячеек) 
   размер merge region выбирается из количества fields.
 Fields - поля которые будут в этом столбце

2.localization-ru.json - файл локализзации

3.real.json - ответ с сервера

4.visibleAttributes.json - видимые аттрибуты. Если поле в этом списке не присутствует, то в xls этого поля не будет

5.attrsWithoutCondition.json - включаем поля, если они в visibleAttributes.json не приходят никогда, то есть условия на них нет.
