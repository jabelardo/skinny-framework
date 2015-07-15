package skinny.engine.implicits

import scala.language.implicitConversions

trait LowestPriorityImplicits extends TypeConverterSupport {

  // TODO: method erasure in trait ClassManifestDeprecatedApis is deprecated: Use runtimeClass instead
  implicit def lowestPriorityAny2T[T: Manifest]: TypeConverter[Any, T] = safe {
    case a if manifest[T].erasure.isAssignableFrom(a.getClass) => a.asInstanceOf[T]
  }

}