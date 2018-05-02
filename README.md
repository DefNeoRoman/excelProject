# excelProject

Шаблон для создания xls документа

groups.json - шаблон

1. Name - имя самого верхнего ряда. (Колонка будет состоять из объединенных ячеек) 
   размер merge region выбирается из количества fields.
2. Fields - поля которые будут в этом столбце

3.localization-ru.json - файл локализзации

4.real.json - ответ с сервера

5.visibleAttributes.json - видимые аттрибуты. Если поле в этом списке не присутствует, то в xls этого поля не будет

6.attrsWithoutCondition.json - включаем поля, если они в visibleAttributes.json не приходят никогда, то есть условия на них нет.
